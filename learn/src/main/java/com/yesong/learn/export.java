package com.yesong.learn;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class export {
    @Test
    public void main() throws Exception {
        List<String> strings = ExcelUtil.readExcel("/Users/mac/Downloads/tm.xlsx");
        File file = new File("/Users/mac/Downloads/sql.txt");
        StringBuffer sql = new StringBuffer();
        Long i = 0L;
        for (String string : strings) {
            sql.append("insert into prizePool(id,code) value ('"+i.toString()+"','"+string+"')  \n");
            i++;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(sql.toString().getBytes());
        fileOutputStream.flush();

    }
}
