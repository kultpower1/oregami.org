package org.oregami.entities;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.oregami.keyobjects.KeyObjects.RoleKey;

@Generated(value="Dali", date="2011-11-30T13:59:24.471+0100")
@StaticMetamodel(User.class)
public class User_ extends BaseEntity_ {
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> activationKey;
	public static volatile SingularAttribute<User, Timestamp> registrationTime;
	public static volatile ListAttribute<User, RoleKey> roleList;
}
