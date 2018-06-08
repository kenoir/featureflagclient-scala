package FeatureFlagTech

import scala.io.Source

object httpClient {

  @throws(classOf[java.io.IOException])
  @throws(classOf[java.net.SocketTimeoutException])
  def get(url: String) = {
    Source.fromURL(url)("ISO-8859-1").mkString
  }

}
