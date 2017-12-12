import org.apache.hadoop.conf.Configuration
import org.apache.spark._
import org.apache.hadoop.hbase.spark._
import org.apache.hadoop.hbase.{HBaseConfiguration, HTableDescriptor}
import org.apache.hadoop.hbase.client.HBaseAdmin
import org.apache.hadoop.hbase.mapreduce.TableInputFormat
import org.apache.hadoop.fs.Path
import org.apache.hadoop.hbase.HColumnDescriptor
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.client.Put
import org.apache.hadoop.hbase.client.HTable
import org.apache.hadoop.hbase.mapred.TableOutputFormat
import org.apache.hadoop.mapred.JobConf
import org.apache.hadoop.hbase.io.ImmutableBytesWritable
import org.apache.hadoop.mapreduce.Job
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat
import org.apache.hadoop.hbase.KeyValue
import org.apache.hadoop.hbase.mapreduce.HFileOutputFormat
import org.apache.hadoop.hbase.mapreduce.LoadIncrementalHFiles
import org.apache.hadoop.hbase.spark.HBaseContext

case class Column(var family : Array[Byte] , var qualifier : Array[Byte] , var value : Array[Byte])
case class Record(var rowKey : Array[Byte], colList : Array[Column])

class hbaseLoad {

  val conf : Configuration = HBaseConfiguration.create()
  val sc = new SparkContext("local", "test")
  val ZOOKEEPER_QUORUM = "WRITE YOUR ZOOKEEPER_QUORUM"
  conf.set("hbase.zookeeper.quorum", ZOOKEEPER_QUORUM)
  val hbaseContext = new HBaseContext(sc, conf)


  // Put Example
  val putList = Array(
    Record(Bytes.toBytes("6"), Array(
      Column(Bytes.toBytes("d"), Bytes.toBytes("name"), Bytes.toBytes("name6")),
      Column(Bytes.toBytes("d"), Bytes.toBytes("phone"), Bytes.toBytes("phone6"))
    )),
    Record(Bytes.toBytes("7"), Array(
      Column(Bytes.toBytes("d"), Bytes.toBytes("name"), Bytes.toBytes("name7")),
      Column(Bytes.toBytes("d"), Bytes.toBytes("phone"), Bytes.toBytes("phone7"))
    )),
    Record(Bytes.toBytes("8"), Array(
      Column(Bytes.toBytes("d"), Bytes.toBytes("name"), Bytes.toBytes("name8")),
      Column(Bytes.toBytes("d"), Bytes.toBytes("phone"), Bytes.toBytes("phone8"))
    ))
  )

  val rdd = sc.parallelize(putList)
  hbaseContext.bulkPut(rdd, "ishassan:test_table", putFunction, true)

  def putFunction (record : Record) : Put = {

    val put = new Put( record.rowKey )
    record.colList.foreach(col => {
      put.addColumn(col.family, col.qualifier, col.value)
    })
    put
  }

}
