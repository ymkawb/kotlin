import some.fooImported

val fooVar = 12
fun fooLocal() = 12

val some = foo<caret>

// "foo" is before other elements because of exact prefix match

// ORDER: foo, fooVar, fooLocal, fooImported, fooNotImported
// NUMBER: 2
// SELECTED: 1