package FeatureFlagTech

import io.circe._
import io.circe.parser._

class FeatureFlagClient(val sourceUrl: String = null, val overrideFeatures: Array[Feature[Any]]) {
	val sourcedFeatures: Json = parse(getSourcedFeatures()).getOrElse(Json.Null)
  val cursor: HCursor = sourcedFeatures.hcursor

  def boolGet(featureName: String): Boolean = {
    val foundFeature = overrideFeatures.filter( f => f.name == featureName )
    if (foundFeature.length > 0) {
      foundFeature(0).value.asInstanceOf[Boolean]
    } else {
      cursor.downField("values").get[Boolean](featureName).right.get
    }
  }

  def intGet(featureName: String): Int = {
    val foundFeature = overrideFeatures.filter( f => f.name == featureName )
    if (foundFeature.length > 0) {
      foundFeature(0).value.asInstanceOf[Int]
    } else {
      cursor.downField("values").get[Int](featureName).right.get
    }
  }

  def stringGet(featureName: String): String = {
    val foundFeature = overrideFeatures.filter( f => f.name == featureName )
    if (foundFeature.length > 0) {
      foundFeature(0).value.asInstanceOf[String]
    } else {
      cursor.downField("values").get[String](featureName).right.get
    }
  }

  def getSourcedFeatures(): String = {
    httpClient.get(sourceUrl)
  }

}