import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Select {
    public static void main(String[] args) {
        List<Student> students = new Select()
                .selectStudent("qq.com", 1);
        System.out.println(students);
    }

    public List<Student> selectStudent(String mail,
                                       Integer classesId) {
        Connection        connection = null;
        PreparedStatement ps         = null;
        ResultSet         rs         = null;
        List<Student>     students   = new ArrayList<>();
        try {
            connection = DBUti_2.getConnection();
            String sql = "select id,sn,name,qq_mail,classes_id" +
                    " from student where qq_mail" +
                    " like ? and classes_id=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + mail);
            ps.setInt(2, classesId);
            rs = ps.executeQuery();
            while (rs.next()) {
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
            // finally始终会执行，如果放try里边，
            // 即便放在最后，也可能执行不到
            DBUti_2.close(connection, ps, rs);
        }
        return students;
    }


    public List<Score> selectScore(Integer score,
                                   Integer classesId) {
        Connection        connection = null;
        PreparedStatement ps         = null;
        ResultSet         rs         = null;
        List<Score>       scores     = new ArrayList<>();
        try {
            connection = DBUti_2.getConnection();
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
            while (rs.next()) {
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
            // finally始终会执行，如果放try里边，
            // 即便放在最后，也可能执行不到
            DBUti_2.close(connection, ps, rs);
        }
        return scores;
    }

    public List<Student> selectScore2(Integer score,
                                      Integer classesId) {
        Connection        connection = null;
        PreparedStatement ps         = null;
        ResultSet         rs         = null;
        List<Student>     students   = new ArrayList<>();
        try {
            connection = DBUti_2.getConnection();
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
            while (rs.next()) {
                Integer id       = rs.getInt("id");
                Student student0 = new Student();
                Score   score0   = new Score();
                boolean isExists = false;
                score0.setScore(rs.getBigDecimal("score"));
                score0.setCourseName(rs.getString("course_name"));
                for (Student student : students) {
                    if (Integer.compare(id, student.getId()) == 0) {
                        student0 = student;
                        isExists =true;
                    }
                }
                student0.setId(rs.getInt("id"));
                student0.setName(rs.getString("student_name"));
                List<Score> existsScores = student0.getScores();
                if (existsScores == null) {
                    existsScores = new ArrayList<>();
                }
                existsScores.add(score0);
                if(!isExists){
                    students.add(student0);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // finally始终会执行，如果放try里边，
            // 即便放在最后，也可能执行不到
            DBUti_2.close(connection, ps, rs);
        }
        return students;
    }
}