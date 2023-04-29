package cbsq










type ::[Receiver, +Addend] = (
   Receiver match {
      case Unit                   => Tuple1[Addend]
      case Tuple1[a1]             => (a1,                 Addend)
      case (a1, a2            )   => (a1, a2,             Addend)
      case (a1, a2, a3        )   => (a1, a2, a3,         Addend)
      case (a1, a2, a3, a4    )   => (a1, a2, a3, a4,     Addend)
      case (a1, a2, a3, a4, a5)   => (a1, a2, a3, a4, a5, Addend)
      
      // case (v1, v2            )   => (v1, v2,             VN)
      // case (v1, v2, v3        )   => (v1, v2, v3,         VN)
      // case (v1, v2, v3, v4    )   => (v1, v2, v3, v4,     VN)
      // case (v1, v2, v3, v4, v5)   => (v1, v2, v3, v4, v5, VN)
   }
)







