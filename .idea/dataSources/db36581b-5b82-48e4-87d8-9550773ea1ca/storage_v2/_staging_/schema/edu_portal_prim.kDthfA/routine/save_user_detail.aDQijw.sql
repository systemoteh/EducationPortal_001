create procedure save_user_detail(IN in_user_id int, IN in_first_name varchar(45), IN in_last_name varchar(45),
                                  IN in_e_mail  varchar(45), IN in_gender tinyint(1), IN in_birth_date datetime,
                                  IN in_counrty varchar(45), IN in_city    varchar(45), OUT out_result tinyint(1))
  BEGIN
    DECLARE temp_user_id int;
    SET temp_user_id = 0;
    SET out_result = FALSE;
    SET autocommit = 0;
    START TRANSACTION;
    SELECT COUNT(1)
        INTO temp_user_id
    FROM user_detail
    WHERE e_mail = TRIM(in_e_mail)
      AND user_id != in_user_id;
    IF (temp_user_id = 0)
    THEN
      UPDATE user_detail
      SET first_name = in_first_name,
          last_name  = in_last_name,
          e_mail     = in_e_mail,
          gender     = in_gender,
          birth_date = in_birth_date,
          country    = in_counrty,
          city       = in_city
      WHERE user_id = in_user_id;
      COMMIT;
      SET out_result = true;
    END IF;
  END;

