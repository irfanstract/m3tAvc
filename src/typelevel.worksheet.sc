







{
   object M {}
   Seq[Singleton](M)
}

{
   object M {}
   val h = Seq[Singleton](M).head
   // h.MirroredMonoType
}

5

EmptyTuple
5 *: (2, 2)
(5 *: (2, 2) ).getClass()
5 *: EmptyTuple
(5 *: EmptyTuple ).getClass()
// (18, )
(5, 2, 7) match
   case v0 *: v1 => (v0, v1)
(5, 7) match
   case v0 *: v1 => (v0, v1)
   case v => s"failed: ${v }"
Tuple1(5) match
   case v0 *: v1 => (v0, v1)
   case v => s"failed: ${v }"

{
   ((_: 1, _: 2, _: 3, _:4, _:5) => {
      ()
   }).tupled
}
((_: 1, _: 2, _: 3, _:4, _:5, _: 1, _: 2, _: 3, _:4, _:5, _: 1, _: 2, _: 3, _:4, _:5) => {
   ()
}).tupled
// summon[util.TupledFunc]
@annotation.experimental
def asTupled[F ](f: F)(using c : util.TupledFunction[F, ?] ) =
   c.tupled(f)
// asTupled((_: 1, _: 2, _: 3, _:4, _:5) => {
//    ()
// })
// asTupled(() => {})






