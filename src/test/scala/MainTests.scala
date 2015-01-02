import org.specs2.mutable._

class Week1Tests extends Specification {
  val solution = new Main	

  "The pyramid function" should {
    "do nothing for non positive n" in {
       solution.pyramid(-1) must have size(0)
    }
    "draw a nice pyramid" in {
      solution.pyramid(5) must be("""    *
   ***
  *****
 *******
*********
      """)
    }
  }

  "The uniq function" should {
    "do nothing if there are no dup." in {
      solution.uniq("ababa") must be("ababa")
    }

    "remove only consecutive dup." in {
      solution.uniq("aabbb") must be("ab")
    }
  }
}
