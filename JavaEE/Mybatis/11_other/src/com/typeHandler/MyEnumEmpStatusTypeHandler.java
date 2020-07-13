package com.typeHandler;

import com.bean.EmpStatus;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义类型处理器
 * 1.实现typeHandler接口，或 继承BaseTypeHandler实现类
 */
public class MyEnumEmpStatusTypeHandler implements TypeHandler<EmpStatus> {
    /**
     * 定义当前数据如何保存到数据库中
     */
    @Override
    public void setParameter(PreparedStatement ps, int i, EmpStatus parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("要保存的状态码："+parameter.getCode());
        ps.setString(i, parameter.getCode().toString());
    }

    /**
     *获取值
     */
    @Override
    public EmpStatus getResult(ResultSet rs, String columnName) throws SQLException {
        //需要根据从数据库中拿到的枚举的状态码返回一个枚举对象
        int code = rs.getInt(columnName);
        System.out.println("从数据库中获取的状态码："+code);
        EmpStatus status = EmpStatus.getEmpStatusByCode(code);
        return status;
    }

    @Override
    public EmpStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
        int code = rs.getInt(columnIndex);
        System.out.println("从数据库中获取的状态码："+code);
        EmpStatus status = EmpStatus.getEmpStatusByCode(code);
        return status;
    }

    @Override
    public EmpStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int code = cs.getInt(columnIndex);
        System.out.println("从数据库中获取的状态码："+code);
        EmpStatus status = EmpStatus.getEmpStatusByCode(code);
        return status;
    }
}
