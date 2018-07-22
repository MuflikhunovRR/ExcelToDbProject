package ru.gotoqa;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Muflikhunov Roman
 */

public class UploadExcelToDb {
    private static final String EXCEL_FILE = "D:\\JAVA\\Java_SRC\\ExcelToDbProject\\src\\main\\resources\\db.xls";

    public static void main(String[] args) throws IOException, ParseException {

        //Read by row
        HSSFWorkbook work  = new HSSFWorkbook(new FileInputStream(EXCEL_FILE));
        HSSFSheet hssfSheet = work.getSheetAt(0);

        int update = 0;
        for (int rn=1; rn<=200; rn++)
        {
            HSSFRow row2 = hssfSheet.getRow(rn);
            // processing row
            HSSFCell first_name = row2.getCell(0);
            HSSFCell second_name = row2.getCell(1);
            HSSFCell phone = row2.getCell(2);
            HSSFCell phone_code = row2.getCell(3);
            HSSFCell passport_number = row2.getCell(4);
            HSSFCell born_country = row2.getCell(5);
            HSSFCell birthday = row2.getCell(6);
            HSSFCell email = row2.getCell(7);
            HSSFCell company = row2.getCell(8);
            HSSFCell job = row2.getCell(9);
            HSSFCell salary = row2.getCell(10);
            HSSFCell state = row2.getCell(11);
            HSSFCell car_mark = row2.getCell(12);
            HSSFCell car_model = row2.getCell(13);
            HSSFCell vin = row2.getCell(14);
            HSSFCell power = row2.getCell(15);
            HSSFCell year = row2.getCell(16);
            HSSFCell car_price = row2.getCell(17);
            HSSFCell hire_date = row2.getCell(18);

            System.out.println("First_name : " + row2.getCell(0));
            System.out.println("Second_name : " + row2.getCell(1));
            System.out.println("Phone : " + row2.getCell(2));
            System.out.println("Phone_code : " + row2.getCell(3));
            System.out.println("Passport_number : " + row2.getCell(4));
            System.out.println("Born_country : " + row2.getCell(5));
            System.out.println("Birthday : " + row2.getCell(6));
            System.out.println("Email : " + row2.getCell(7));
            System.out.println("Company : " + row2.getCell(8));
            System.out.println("Job : " + row2.getCell(9));
            System.out.println("Salary : " + row2.getCell(10));
            System.out.println("State : " + row2.getCell(11));
            System.out.println("Car_mark : " + row2.getCell(12));
            System.out.println("Car_model : " + row2.getCell(13));
            System.out.println("Vin : " + row2.getCell(14));
            System.out.println("Power : " + row2.getCell(15));
            System.out.println("Year : " + row2.getCell(16));
            System.out.println("Car_price : " + row2.getCell(17));
            System.out.println("Hire_date : " + row2.getCell(18));
            System.out.println("---------------------------------------");

            //Format date
            DateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
            Date formatBirthday = format.parse(birthday.toString());
            // Wed Dec 27 00:00:00 MSK 1978 System.out.println(date);

            //12.08.1968
            DateFormat format2 = new SimpleDateFormat("yyyy");
            Date formatYear = format2.parse(year.toString());

            Date formatHireDate= format.parse(hire_date.toString());


            ClassPathXmlApplicationContext contextdb = new ClassPathXmlApplicationContext("db.xml");
            NamedParameterJdbcTemplate nquOracle = new NamedParameterJdbcTemplate(contextdb.getBean(DataSource.class));

            HashMap<String, Object> param = new HashMap<>();
            param.put("first_name", first_name.toString());
            param.put("second_name", second_name.toString());
            param.put("phone", phone.toString());
            param.put("phone_code", phone_code.toString());
            param.put("passport_number", passport_number.toString());
            param.put("born_country", born_country.toString());
            param.put("formatBirthday", formatBirthday);
            param.put("email", email.toString());
            param.put("company", company.toString());
            param.put("job", job.toString());
            param.put("salary", salary.toString());
            param.put("state", state.toString());
            param.put("car_mark", car_mark.toString());
            param.put("car_model", car_model.toString());
            param.put("vin", vin.toString());
            param.put("power", power.toString());
            param.put("formatYear", formatYear);
            param.put("car_price", car_price.toString());
            param.put("hire_date", formatHireDate);
            String insertSql = "INSERT INTO PERSON_TEMP (id, First_name, Second_name, Phone, Phone_code, Passport_number, Born_country, " +
                    "Birthday, Email, Company, Job, Salary, State, Car_mark, Car_model, Vin, Power, Year,  Car_price, Hire_date) VALUES " +
                    "(id, :first_name, :second_name, :phone, :phone_code, :passport_number, :born_country, :formatBirthday, :email, :company, :job, :salary, :state, :car_mark, :car_model, :vin, :power,  :formatYear, :car_price, :hire_date)";

            // execute insert + count number of records / records processed by the executed query
            nquOracle.update(insertSql, param);
            update ++;

        }
        System.out.println(+update+ " records in db.");
    }
}

