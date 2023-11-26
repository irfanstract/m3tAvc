



# needing to simultaneously develop multiple libraries in a single repo (hence "monorepo")

needing to simultaneously develop multiple libraries in a single repo (hence the term "monorepo") .

those *library*s deal with:
- *elementary trigonometry*
- *the 12 staircases in each octave*
- (*experimental*) *Scala-based interface to [React](https://react.dev)*
- more

see the file `build.sbt` for the complete project graph.

splitting into multiple "project"s (the term "project" in SBT's terminology)
is very important ;
splitting
helps isolating "compile error"s, possibly some hard-to-reason ones - some being spurious complaints, some being `the compiler crashed with an exception`s (eg `AssertionError`) -
to smaller parts of the source tree,
allowing the *upstream/base* remainder to
regain successful compilation despite such "compile error"s in the affected trees
.

the `build.sbt` defines
multiple "project"s (the term "project" in SBT's terminology),
with inter-"project" *dependencies*,
whilst (for now) avoiding the need to publish the *package*s
.






















