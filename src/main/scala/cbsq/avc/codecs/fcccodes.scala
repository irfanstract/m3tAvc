package cbsq.avc.codecs













sealed 
trait FccCodeRegsQueryOps {
  
  type Reg <: RegOps
  // protected 
  export FccCodeRegsOps.RegOps

  def registereds: Set[Reg]
  
  /**
    * all the file-exts each together with its assoc. 
    *
    * note that an ext might have multiple assoc(s)
    *
    */
  inline def registeredsFileExtsAssoc =
    registereds
      .flatMap(reg => (
        reg.fileNameExts
        .map(fext => (fext, reg))
      ))
      .toSet
  /**
    * all the file-exts.
    * 
    * note that an ext might have multiple assoc(s)
    *
    */
  inline def registeredsFileExts: Set[? <: String] =
    registeredsFileExtsAssoc
      .toMap
      .keySet

}

object FccCodeRegsOps
{
  
  sealed 
  trait RegOps {
    lazy val fileNameExts  : Set[? <: String] = Set()
    lazy val mimeTypes     : Set[? <: String] = Set()
  }
  
}
sealed 
trait FccCodeRegsOps 
extends 
AnyRef 
with FccCodeRegsQueryOps
{
  
  type Reg >: RegOps <: RegOps

  protected 
  def registerFmt(desc: Reg): desc.type

  @deprecated("experimental")
  abstract class #%%() extends 
  AnyRef 
  with RegOps 
  { thisEntry =>
    
    registerFmt(thisEntry)

    override def toString(): String = 
      "FccEntry : " + (
        Map(
          "mimeTypes"      -> mimeTypes      ,
          "fileNameExts"   -> fileNameExts   ,
        )
        .toString()
        .replaceFirst("Map", "")
      )

  }

}
lazy val fccCodeRegs: FccCodeRegsOps = 
  new fccCodeRegsImpl
@deprecated("experimental")
def newFccCodeRegistry: FccCodeRegsOps =
  new fccCodeRegsImpl
protected 
class fccCodeRegsImpl extends FccCodeRegsOps
{

  type Reg >: RegOps <: RegOps 
  
  private 
  lazy val lsc =
    new java.util.concurrent.atomic.AtomicReference[Set[Reg] ](Set() )

  def registereds =
    lsc.get()

  def registerFmt(addend: Reg): addend.type =
    lsc
      .updateAndGet(existingList => {
        if (existingList contains addend) {
          existingList
        } else {
          val existingMimeTypes = 
            existingList
            .flatMap(e => e.mimeTypes )
          val wouldReregisteredMimeTypes = (
            existingMimeTypes.toSet[String] & addend.mimeTypes.toSet[String]
          )
          require((
            wouldReregisteredMimeTypes
            .isEmpty
          ), s"'mimeTypes' conflict, $wouldReregisteredMimeTypes in ${addend.mimeTypes }" )
          existingList incl addend
        }
      })
    addend

}

inline def test1(): Unit = 
  fccCodeRegs.registereds
  .map(e => (
    e.fileNameExts
  ))







