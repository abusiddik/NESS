package com.ness.configuration;


import com.ness.entity.Admin;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Maruf
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {

    @Bean
    public HibernateTemplate hibernateTemplate() {
        return new HibernateTemplate(sessionbuilder());
    }

    @Bean
    public SessionFactory sessionbuilder() {
        LocalSessionFactoryBuilder sessionbuilder = new LocalSessionFactoryBuilder(getDataSource());

      sessionbuilder.addAnnotatedClasses(Admin.class);
//        sessionbuilder.addAnnotatedClasses(Candidate.class);
//        sessionbuilder.addAnnotatedClasses(CandidateLogin.class);
//        sessionbuilder.addAnnotatedClasses(CandidateType.class);
//        sessionbuilder.addAnnotatedClasses(Districts.class);
//        sessionbuilder.addAnnotatedClasses(Divisions.class);
//        sessionbuilder.addAnnotatedClasses(Election.class);
//        sessionbuilder.addAnnotatedClasses(ElectionType.class);
//        sessionbuilder.addAnnotatedClasses(Party.class);
//        sessionbuilder.addAnnotatedClasses(PartyAdmin.class);
//        sessionbuilder.addAnnotatedClasses(PartyAdminLogin.class);
//        sessionbuilder.addAnnotatedClasses(QuestionTable.class);
//        sessionbuilder.addAnnotatedClasses(Seats.class);
//        sessionbuilder.addAnnotatedClasses(Symbols.class);
//        sessionbuilder.addAnnotatedClasses(Unions.class);
//        sessionbuilder.addAnnotatedClasses(Upazillas.class);
//        sessionbuilder.addAnnotatedClasses(VoteCenters.class);
//        sessionbuilder.addAnnotatedClasses(VoteCount.class);
//        sessionbuilder.addAnnotatedClasses(VoterInfo.class);
//        sessionbuilder.addAnnotatedClasses(Wards.class);
//        sessionbuilder.addAnnotatedClasses(VoterLogin.class);

        return sessionbuilder.buildSessionFactory();
    }

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/evoting");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean
    public HibernateTransactionManager hibTransMan() {
        return new HibernateTransactionManager(sessionbuilder());
    }
}
