package DEMO;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Select {
    public List<Student> selectStudent(String mail, Integer classesId){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList<>();
        try {
            // 创建数据库连接
            connection = DBUtil.getConnection();
            // ？ 为占位符
            String sql = "select id,sn,name,qq_mail,classes_id" +
                    " from student where qq_mail" +
                    " like ? and classes_id=?";
            // 创建操作命令对象 statement ，并将占位符替换为实际的值
            ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + mail);
            ps.setInt(2, classesId);
            // 用 statement 执行 SQL 语句，并返回结果集 ResultSet
            rs = ps.executeQuery();
            // 处理结果集：ResultSet 对象类似一个 List<Map> 的集合
            // rs.next() 处理结果集每一行数据，类似 List 的每个数据
            while(rs.next()){
                // 使用 rs.getInt()、rs.getString()等方法
                // 处理每行数据，类似 Map.get() 根据键值获取数据
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setSn(rs.getInt("sn"));
                student.setName(rs.getString("name"));
                student.setQqMail(rs.getString("qq_mail"));
                student.setClassesId(rs.getInt("classes_id"));
                students.add(student);
                System.out.println(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // finally 始终会执行
            // 如果放到最后，有可能执行不到
            DBUtil.close(connection, ps, rs);
        }
        return students;
    }

    /**
     * 查询指定班级分数及格的信息
     * @param score 查询条件：在该分数以上
     * @param classesId 查询条件：班级id
     * @return  获取分数集合
     */
    public List<Score> selectScore(Integer score, Integer classesId){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Score> scores = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            String sql = "SELECT" +
                    " stu.id," +
                    " stu.NAME student_name," +
                    " cou.NAME course_name," +
                    " sco.score " +
                    " FROM" +
                    " score sco" +
                    " JOIN student stu ON sco.student_id = stu.id" +
                    " JOIN course cou ON sco.course_id = cou.id " +
                    " WHERE" +
                    " sco.score >= ? " +
                    " AND stu.classes_id =?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, score);
            ps.setInt(2, classesId);
            rs = ps.executeQuery();
            while (rs.next()){
                Score score0 = new Score();
                score0.setStudentId(rs.getInt("id"));
                score0.setStudentName(rs.getString("student_name"));
                score0.setCourseName(rs.getString("course_name"));
                score0.setScore(rs.getBigDecimal("score"));
                scores.add(score0);
                System.out.println(score0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, ps, rs);
        }
        return scores;
    }

    /**
     * 查询指定班级分数及格的信息
     * @param score
     * @param classesId
     * @return  学生信息的集合，每个学生中包含多个分数信息List<Score>
     */
    public List<Student> selectScore2(Integer score, Integer classesId){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            String sql = "SELECT" +
                    " stu.id," +
                    " stu.sn," +
                    " stu.NAME student_name," +
                    " stu.qq_mail," +
                    " cou.NAME course_name," +
                    " sco.score " +
                    " FROM" +
                    " score sco" +
                    " JOIN student stu ON sco.student_id = stu.id" +
                    " JOIN course cou ON sco.course_id = cou.id " +
                    " WHERE" +
                    " sco.score >= ? " +
                    " AND stu.classes_id =?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, score);
            ps.setInt(2, classesId);
            rs = ps.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                Student student0 = null;
                boolean isExists = false;

                // 根据 ID 在返回集合中获取已有的学生
                for(Student student : students){
                    if(Integer.compare(id, student.getId()) == 0){
                        student0 = student;
                        isExists = true;
                    }
                }
                // 返回集合中若没有该学生，则创建该学生对象，并从结果集中获取
                // 属于学生的信息，对学生对象设值，再将该学生对象添加到返回集合
                if(!isExists){
                    student0 = new Student();
                    student0.setId(rs.getInt("id"));
                    student0.setSn(rs.getInt("sn"));
                    student0.setName(rs.getString("student_name"));
                    student0.setQqMail(rs.getString("qq_mail"));
                    students.add(student0);
                }

                // 获取学生对象中的分数集合，如果为空，则新建并设置到学生对象中
                List<Score> existsScores = student0.getScores();
                if(existsScores == null){
                    existsScores = new ArrayList<>();
                    student0.setScores(existsScores);
                }

                // 将当前结果集中的分数信息添加到学生对象中的分数集合
                Score   score0   = new Score();
                score0.setScore(rs.getBigDecimal("score"));
                score0.setCourseName(rs.getString("course_name"));
                existsScores.add(score0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, ps, rs);
        }
        return students;
    }
















    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select id,sn,name,qq_mail,classes_id" +
                    " from student where qq_mail" +
                    " like ? and classes_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,"%qq.com%");
            ps.setInt(2,1);
            rs = ps.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                Integer sn = rs.getInt("sn");
                String name = rs.getString("name");
                String qqMail = rs.getString("qq_mail");
                Integer classesId = rs.getInt("classes_id");
                System.out.println(String.format("id = %s, sn = %s, name = %s," +
                        " mail = %s, classesId = %s",
                        id, sn, name,qqMail,classesId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // finally 始终会执行，如果放 try 里边，即便放在最后，也可能执行不到
            DBUtil.close(connection, ps, rs);
        }
    }
}
