package com.rigid.jpademos.controller;

import com.caimao.common.helper.xlsx.XlsxColumn;
import com.caimao.common.helper.xlsx.XlsxWork;
import com.rigid.jpademos.entity.StudentEntity;
import com.rigid.jpademos.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @tool: Created with IntelliJ IDEA
 * @program: JpaDemos
 * @description: Excle表单的导出测试
 * @author: Rigid_Shuai
 * @create: 2019-10-16 16:04
 */
@RestController
@RequestMapping("/xlsxTest")
public class ExcleExportController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/xlsxExport")
    public void xlsxExport(HttpServletResponse response) throws IOException, NoSuchMethodException {
        List<StudentEntity> studentEntityList = studentService.findAllStudent();

        //调用封装的方法
        XlsxWork xlsxWork = new XlsxWork();

        XlsxColumn[] xlsxTest1 = {
                new XlsxColumn(StudentEntity.class, "getId", "序号"),
                new XlsxColumn(StudentEntity.class, "getStudentName", "名字"),
        };
        xlsxWork.createSheet("测试1", xlsxTest1, studentEntityList);

        XlsxColumn[] xlsxTest2 = {
                new XlsxColumn(StudentEntity.class, "getStudentAge", "序号"),
                new XlsxColumn(StudentEntity.class, "getStudentSex", "名字"),
        };
        xlsxWork.createSheet("测试2", xlsxTest2, studentEntityList);


        //设置强制下载不打开
        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" + java.net.URLEncoder.encode("测试列表" + ".xlsx", "UTF-8"));
        xlsxWork.getWb().write(response.getOutputStream());
    }
}
