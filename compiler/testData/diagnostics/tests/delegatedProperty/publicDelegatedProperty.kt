<!PUBLIC_MEMBER_SHOULD_SPECIFY_TYPE!>public val a<!> by Delegate()

class Delegate {
  fun get(t: Any?, p: String): Int {
    t.equals(p) // to avoid UNUSED_PARAMETER warning
    return 1
  }
}