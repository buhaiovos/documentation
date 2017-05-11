package edu.cad.uils.documentutils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;

public class FormulaExtender {
    
    public static void extendFormula(Sheet sheet, Cell src, Cell dest){
        Cell formulaCell = sheet.getRow(dest.getRowIndex() + 1).getCell(dest.getColumnIndex());
        
        if(!formulaCell.getCellTypeEnum().equals(CellType.FORMULA))
            return;
        System.out.print(src.getAddress().toString() + " ");
        String formula = formulaCell.getCellFormula();
        formula = formula.replaceAll(":" + src.getAddress().toString(), 
                ":" + dest.getAddress().toString());
        
        formulaCell.setCellFormula(formula);
    }
}
