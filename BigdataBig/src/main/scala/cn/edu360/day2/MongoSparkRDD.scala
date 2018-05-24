package cn.edu360.day2

import com.mongodb.spark.MongoSpark
import com.mongodb.spark.rdd.MongoRDD
import org.apache.spark.{SparkConf, SparkContext}
import org.bson.Document

/**
  * Created by zx on 2017/10/8.
  * https://docs.mongodb.com/spark-connector/current/
  * https://docs.mongodb.com/spark-connector/current/scala-api/
  */
object MongoSparkRDD {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("MongoSPRDD") // RDD 名称
      .setMaster("local") // 运行方式
      .set("spark.mongodb.input.uri", "mongodb://bike:bike@192.168.187.111:27017/bike.logs") // 数据源
      .set("spark.mongodb.output.uri", "mongodb://bike:bike@192.168.187.111:27017/bike.result") // 结果输出

    // 创建SparkContext(RDD, SparkCore)
    val sc = new SparkContext(conf)
    val docRDD: MongoRDD[Document] = MongoSpark.load(sc)

    // pv uv
    val pv = docRDD.count()

    val uv = docRDD.map(doc => {
      doc.getString("openid")
    }).distinct().count() // 去重

    println(pv + "---" + uv)

    sc.stop()
  }

//  def main(args: Array[String]): Unit = {
//
//    val conf = new SparkConf()
//      .setAppName("MongoSparkRDD")
//      .setMaster("local[*]")
//      .set("spark.mongodb.input.uri", "mongodb://xiaoniu:123568@192.168.100.101:27017/xiaoniu.logs")
//      .set("spark.mongodb.output.uri", "mongodb://xiaoniu:123568@192.168.100.101:27017/xiaoniu.reslut")
//    //创建sparkcontext(RDD,SparkCore)
//    val sc = new SparkContext(conf)
//
//    val docsRDD: MongoRDD[Document] = MongoSpark.load(sc)
//
////    val filtered: RDD[Document] = docsRDD.filter(doc => {
////      val age = doc.get("age")
////      if (age == null) {
////        false
////      } else {
////        val ageDouble = age.asInstanceOf[Double]
////        ageDouble >= 31
////      }
////    })
//
//    //先过滤，filteredRDD，缓存（cache）用来提高效率
//
//    val pv = docsRDD.count()
//
//    val uv = docsRDD.map(doc => {
//      doc.getString("openid")
//    }).distinct().count()
//
//
//    println("pv: " + pv + " uv: " + uv)
//
//    // 创建RDD
//    //val r = docsRDD.collect()
//
//    //println(r.toBuffer)
//
//    //val filtered = docsRDD.withPipeline(Seq(Document.parse("{ $match: { age : { $gt : 31 } } }")))
//
//    //println(filtered.collect().toBuffer)
//    //val documents = sc.parallelize((1 to 10).map(i => Document.parse(s"{age: $i}")))
//
//    //val r = filtered.collect()
//
//    //println(r.toBuffer)
//
//    //将计算好的结果保存到mongo中
//    //MongoSpark.save(filtered)
//
//    sc.stop()
//
//    //    val spark = SparkSession.builder()
//    //      .master("local")
//    //      .appName("MongoSparkConnectorIntro")
//    //      .config("spark.mongodb.input.uri", "mongodb://192.168.1.13:27200/niu.bi")
//    //      //.config("spark.mongodb.output.uri", "mongodb://127.0.0.1/test.myCollection")
//    //      .getOrCreate()
//    //
//    //    val df: DataFrame = MongoSpark.load(spark)
//    //
//    //    df.show()
//
//
//  }
}
