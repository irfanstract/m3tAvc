package orgscalacodetesting






object MathUtils extends MathUtilsOps[Double] :
   def twiceOf[Value <: Double](v: Value) =
      2 * v

end MathUtils

sealed trait MathUtilsOps[AcceptableValue <: Double | Long | Int] :
   /**
     * twice of `v`.
     *
     * @param value
     * @return
     */
   def twiceOf[Value <: AcceptableValue](value: Value): AcceptableValue

end MathUtilsOps



