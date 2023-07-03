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

@main
def runListModelAdapterDemo() : Unit = {

   import language.unsafeNulls

   val xSwing = {
      avcframewrk.forms.impl.generic.XAllComponentsList.defaultInstance
   }

   val m = {
      getStaticListModel({
         // "favulous"
         "Terminal will be reused by tasks, press any key to close it."
         .toIndexedSeq
         .map((e: Char) => s"Char($e)")
      })
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
         new javax.swing.JScrollPane(tableComp)
      }
   }
}

;
















