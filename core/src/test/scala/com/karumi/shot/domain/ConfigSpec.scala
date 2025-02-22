package com.karumi.shot.domain

import com.karumi.shot.mothers.BuildTypeMother
import org.scalatest.flatspec._
import org.scalatest.matchers._

class ConfigSpec extends AnyFlatSpec with should.Matchers {

  "Config" should "use the screenshot tests library implemented by Facebook" in {
    Config.androidDependency shouldBe "com.karumi:shot-android:5.10.5"
  }

  it should "add the dependency using the androidTestImplementation mode" in {
    Config.androidDependencyMode shouldBe "androidTestImplementation"
  }

  it should "save the screenshots into the screenshots folder" in {
    Config.screenshotsFolderName(
      BuildTypeMother.anyFlavor,
      BuildTypeMother.anyBuildType
    ) shouldBe s"/screenshots/${BuildTypeMother.anyFlavor}/${BuildTypeMother.anyBuildType}/"
  }

  it should "point at the temporal screenshots folder" in {
    Config.pulledScreenshotsFolder(
      BuildTypeMother.anyFlavor,
      BuildTypeMother.anyBuildType
    ) shouldBe s"/screenshots/${BuildTypeMother.anyFlavor}/${BuildTypeMother.anyBuildType}/screenshots-default/"
  }

  it should "point at the metadata folder" in {
    Config.metadataFileName(
      BuildTypeMother.anyFlavor,
      BuildTypeMother.anyBuildType
    ) shouldBe s"/screenshots/${BuildTypeMother.anyFlavor}/${BuildTypeMother.anyBuildType}/screenshots-default/metadata.xml"
  }

  it should "point at the tmp folder" in {
    Config.screenshotsTemporalRootPath shouldBe "/tmp/shot/screenshot/"
  }

}
