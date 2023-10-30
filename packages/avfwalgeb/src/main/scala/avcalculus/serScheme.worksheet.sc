

import avcalculus.{*, given }

import com.github.plokhotnyuk.jsoniter_scala







def jsc[T]
   (using impl : jsoniter_scala.core.JsonValueCodec[T] )
: impl.type
= impl

musical.InTwelvethKey.values.toIndexedSeq

jsoniter_scala.core.writeToStringReentrant (musical.InTwelvethKey.C )(using jsc[musical.InTwelvethKey ] )

jsoniter_scala.core.writeToStringReentrant (musical.InTwelvethKey.C_SHARP )(using jsc[musical.InTwelvethKey ] )

jsoniter_scala.core.writeToStringReentrant (musical.Key.byFromCKeyDeviation(trig.Angular.fromDegrees(30 ) ) )(using jsc[musical.Key._Any ] )

jsoniter_scala.core.writeToStringReentrant (musical.Key.byFromCKeyDeviation(trig.Angular.fromDegrees(45 ) ) )(using jsc[musical.Key._Any ] )










