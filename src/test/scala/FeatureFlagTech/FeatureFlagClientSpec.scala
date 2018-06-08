package FeatureFlagTech

import org.scalamock.scalatest.MockFactory
import org.scalatest.FunSpec

class FeatureFlagClientSpec extends FunSpec with MockFactory {

  val featureFlagClientMock = mock[FeatureFlagClient]



  describe( "FeatureFlagClient") {

    it("*Get() methods") {

//      object foo {
//        val bar: String = "car"
//      }

      val f2c = new FeatureFlagClient(
          "https://featureflag.tech/node/exampleflag.json",
          Array(
            new Feature("trueBoolean", true),
            new Feature("falseBoolean", false),
            new Feature("number", 33),
   //         new Feature("array", Array(1, 2)),
   //         new Feature("object", foo),
            new Feature("text", "laser wolf")
          )
      )

      assert(f2c.boolGet("trueBoolean") === true)
      assert(f2c.boolGet("falseBoolean") === false)
      assert(f2c.intGet("number") === 33)
//      assert(f2c.arrayGet("array") === Array(1, 2))
//      assert(f2c.get("object") === foo)
      assert(f2c.stringGet("text") === "laser wolf")

    }

  }

}
