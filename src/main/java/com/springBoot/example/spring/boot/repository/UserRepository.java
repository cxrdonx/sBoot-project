package com.springBoot.example.spring.boot.repository;

import com.springBoot.example.spring.boot.dto.UserDto;
import com.springBoot.example.spring.boot.entity.User;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select u from User u Where u.email=?1")
   Optional<User> findByUserEmail(String email);
    @Query("select u from User u where u.name like ?1%")
    List<User>findAndSort(String name, Sort sort);
    List<User> findByName(String name);
    Optional<User>findByEmailAndName(String email, String name);
    /*
    @Query("SELECT new com.springBoot.example.spring.boot.dto.UserDto(u.id, u.name, U.birthDate)" +
            "FROM User u " +
            "WHERE u.birthDate=:dateParameter" +
            " AND u.email=:emailParameter")
    Optional<UserDto> getAllByBirthDateAndEmail(@Param("dateParameter")LocalDate date, @Param("emailParameter") String email);
*/

}
