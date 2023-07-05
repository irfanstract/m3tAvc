package avcframewrk.forms.javaswing

















;

def getStaticListModel[E](src : Seq[E] ): javax.swing.ListModel[E] = {

   import language.unsafeNulls

   new javax.swing.AbstractListModel[E] {

      val lengthImpl = src.length

      def getSize(): lengthImpl.type = lengthImpl

      def getElementAt(i: Int) = src apply(i)
      
   }
}

extension [E](src : javax.swing.ListModel[E] ) {

   def asReadOnly() : javax.swing.ListModel[E] = {

      new javax.swing.ListModel[E] {

         export src.getSize

         export src.getElementAt

         export src.{addListDataListener, removeListDataListener }
         
      }
   }

}

extension [E](src : javax.swing.ListModel[E] ) {

   def items = {

      import language.unsafeNulls

      IndexedSeq.tabulate[E](src.getSize() )(src.getElementAt _ )
   }
   
}

export encbmDefNames.newComboBoxModelWithSyncedOptionList

protected
object encbmDefNames {
   
   import language.unsafeNulls

   /**
    * 
    * new `ComboBoxModel`
    * with independent *selection-state*
    * yet
    * whose *option-list* will (exactly) be a view of the specified `ListModel`
    * 
    */
   def newComboBoxModelWithSyncedOptionList[E](
      //
      src: javax.swing.ListModel[? <: E] ,

   ): javax.swing.ComboBoxModel[E] = {

      peer
      object peer extends javax.swing.DefaultComboBoxModel[E] {

         override
         def getSize() = {

            super.getSize()
         }

         locally {

            
         }

      }

      def refresh() : Unit = {

         for (item <- src.items ) {
            peer.addElement(item )
         }

      }

      def pickBySrcEvt(x0: javax.swing.event.ListDataEvent ) = {

                        {
                           src.items
                           .zipWithIndex
                           .filter({ case (e, i) => (x0.getIndex0() <= i && i <= x0.getIndex1() ) })
                        }
      }

      {
       
            assert(peer.getSize() == 0 )
            
            refresh()

            assert(peer.getSize() == src.getSize() )

            src addListDataListener({

               object l extends javax.swing.event.ListDataListener {

                  // TODO
                  def contentsChanged(x0: javax.swing.event.ListDataEvent ): Unit = {
                     refresh()
                  }

                  def intervalAdded(x0: javax.swing.event.ListDataEvent ): Unit = {
                     peer.addAll(x0.getIndex0, {
                        {
                           pickBySrcEvt(x0)
                           .map(_._1)
                        }
                        match { case c => {
                           ;
                           import scala.jdk.CollectionConverters.*
                           c.asJava
                        } }
                     })
                  }
                  
                  def intervalRemoved(x0: javax.swing.event.ListDataEvent | Null): Unit = {
                     for (i <- pickBySrcEvt(x0).map(_._2).reverse ) {
                        peer removeElementAt i
                     }
                  }

               }
               
               l
            })
              
      }

      new AnyRef with javax.swing.ComboBoxModel[E] {
         
         // Members declared in javax.swing.ComboBoxModel
         export peer.{getSelectedItem, setSelectedItem}
         
         // Members declared in javax.swing.ListModel
         export peer.{getSize, getElementAt }

         export peer.{addListDataListener, removeListDataListener }

      }
   }

}

extension [E](src : javax.swing.ListModel[E] ) {

   def asTableModel(
      itemCls : java.lang.Class[? >: E] ,
      
   )(using reflect.Typeable[E]) : javax.swing.table.TableModel = {

      import language.unsafeNulls

      val srcAsEditableOptional : Option[javax.swing.DefaultListModel[E] ] = {

         Some[src.type ](src )
         .collect({
            case ls : javax.swing.DefaultListModel[etype] =>
               ls
         })
         // .collect({ case ls : e.type => ls })
      }

      new javax.swing.table.AbstractTableModel {
         
         def getColumnCount(): 1 | 2 = 2

         def getRowCount(): SrcGotSizeValue = src.getSize()

         opaque type SrcGotSizeValue <: Int = Int
         
         protected 
         def getColumnImpl( colIndex: Int ) : (String, IndexedSeq[?], java.lang.Class[?], Option[(Int, E) => Unit]) = {

            colIndex match {

               case col @ 0 if ((col + 1 ) < getColumnCount() ) =>
                  ("i", Range(0, getRowCount() ), classOf[Int], None )

               case _ =>
                  ("\u00A0", {
                     IndexedSeq.tabulate(getRowCount() )(i => { src getElementAt(i) })
                  }, itemCls, (
                     srcAsEditableOptional
                     map(s => (identity[(Int, E) => Unit] ((i, e) => s.set(i, e) ) ) )
                  ) )

            }
         }
         
         def getValueAt(rowIndex: Int, colIndex: Int) = {
            
            getColumnImpl(colIndex)
            ._2
            .apply(rowIndex)
         }

         /* THE OPTIONAL METHODS */

         override
         def getColumnName(col: Int) = {
            
            getColumnImpl(col)
            ._1
         }
         
         override
         def getColumnClass(col: Int) = {

            getColumnImpl(col)
            ._3
         }

         override
         def isCellEditable(rowIndex: Int, columnIndex: Int): Boolean = {

            getColumnImpl(columnIndex)._4
            .nonEmpty
         }

         override
         def setValueAt(newValue: java.lang.Object, rowIndex: Int, columnIndex: Int): Unit = {

            (getColumnImpl(columnIndex)._4 , newValue) match {
               //

               case (None, _) =>
                  /* ignore */

               //
               case (Some(setValueImplAtRow), newValue0) =>
                  //

                  val Some(newValue) = {

                     summon[reflect.TypeTest[newValue0.type, E] ]
                     .unapply(newValue0 )
                  }

                  setValueImplAtRow(rowIndex, newValue )

            }
         }
         
      }
   }

}

/**
 * 
 * demo
 * the `ListModel` views as `TableModel`
 * 
 */
@main
def runListModelAdapterDemo() : Unit = {

   import language.unsafeNulls

   val xSwing = {
      avcframewrk.forms.impl.generic.XAllComponentsList.defaultInstance
   }

   val m = {
      newRlsmdListModel()
   }

   xSwing `open` {
      xSwing getCustomComponent1 {
         val tableComp = {
            ;
            new javax.swing.JTable({
               m
               .asTableModel(itemCls = classOf[java.lang.Object ] )
            })
         }
         tableComp setDragEnabled(true)
         new javax.swing.JScrollPane(tableComp)
      }
   }
}

/**
 * 
 * demo
 * the `ListModel` views as `ComboBoxModel`
 * 
 */
@main
def runListModelChoiceAdapterDemo() : Unit = {

   import language.unsafeNulls

   import concurrent.ExecutionContext.Implicits.*

   val xSwing = {
      avcframewrk.forms.impl.generic.XAllComponentsList.defaultInstance
   }

   import javax.swing
   import java.awt

   val mOriginal = {
      locally[swing.DefaultListModel[Int] ] {

         new swing.DefaultListModel[Int]()
      }
   }
   val m = {
      newComboBoxModelWithSyncedOptionList(mOriginal )
   }
   def addIntoM() : Unit = {
      mOriginal add(0, mOriginal.size() )
   }

   /**
    * 
    * spawn
    * a thread to periodically mutate the model
    * 
    */
   summon[concurrent.ExecutionContext]
   .execute(() => {

      for (_ <- Range(0, 5) ) {
         addIntoM()
      }

      assert(0 < mOriginal.getSize() )
      assert(0 < m.getSize() )

      while ({ Thread.sleep((8.5 * 1000 ).toLong ) ; true }) {
         
         addIntoM()
         
      }
      
   })

   // Thread.sleep(6 * 1000)

   /**
    * 
    * spawn some test outlets.
    * needs more-than-one,
    * to exam/test the sync across multiple outlets
    * 
    */
   for (i <- Range(0, 2) ) {
      ;

      xSwing `open` {
         xSwing getCustomComponent1 {
            val p = new swing.JPanel(new java.awt.FlowLayout )
            p add { new swing.JComboBox(m ) }
            p add { new swing.JLabel("component" ) }
            p
         }
      }

   }
}

/**
 * 
 * the ad-hoc `javax.swing.ListModel` impl
 * 
 */
@deprecated
def newRlsmdListModel(): ([C[_]] =>> (C[String] ) )[javax.swing.ListModel ] = {

   import language.unsafeNulls

   {
      getStaticListModel({
         // "favulous"
         "Terminal will be reused by tasks, press any key to close it."
         .split("\\b(?:(?<=\\w)(?!\\s|\\w)|(?<!\\s|\\w)(?=\\w))|\\s+").toIndexedSeq
      })
   }
}

;
















