import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.functions.{col, mean, sum, count, countDistinct}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}


object Main {

  val conf = new SparkConf()
    .setAppName("POC")
    .setMaster("local[2]")
    .set("spark.sql.streaming.checkpointLocation", "checkpoint")


  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(conf)
    val spark = SparkSession.builder.config(sc.getConf).getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    val myArray = sc.textFile("C://myWords.txt")

    // ამოცანა 1
    val flatArray = myArray.flatMap(line => line.split(" "))
    flatArray.foreach(println)

    // ამოცანა 2
    val countArray = flatArray.map(word => (word, 1)).reduceByKey(_ + _).collect()
    countArray.foreach(println)

    // ამოცანა 3
    // splitRDD მეთოდი არ არსებობს, არ ვიცი რა იგულისხმება :)
    val myEmployees = spark.read.option("header","true").csv("C://Employees.csv")
    val groupedMyEmp = myEmployees.groupBy("Department").agg(mean("year"))
    groupedMyEmp.show()

    // ამოცანა 4
    val schema = new StructType()
      .add(StructField("Year", IntegerType, true))
      .add(StructField("Name", StringType, true))
      .add(StructField("Department", StringType, true))
      .add(StructField("Country", StringType, true))

    val employeeDetails = spark.read.schema(schema).json("C://Employees.json")
    employeeDetails.printSchema()

    // ამოცანა 5
    val partialDF = employeeDetails.select("Department", "Name")
    val aggregationDF = partialDF.groupBy("Department").agg(count("Name"))
    aggregationDF.show()

    // ამოცანა 6
    val empJson = spark.sql("SELECT * FROM json.`C://Employees.json`")
    empJson.show()
    val groupedEmpJson = empJson.groupBy("Departments").agg(count("Country"))
    groupedEmpJson.show()
  }
}
