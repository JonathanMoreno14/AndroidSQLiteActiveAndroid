
# AndroidSQLiteActiveAndroid
Sample Item list Application that uses SQLite and ActiveAndroid

The application uses *CRUD* operations. 

The operations: *C* and *R* *(Create and Read)* & *D* *(Delete)*


![androidsqliteactiveandroid](https://cloud.githubusercontent.com/assets/11635523/16352680/412fdc50-3a36-11e6-8c28-ecc93f2f6bac.gif)


To use **ActiveAndroid** you will need to  go to your project level **build.gradle** file and add the following to the **allprojects**

```gradle
 mavenCentral()
 maven { url "https://oss.sonatype.org/content/repositories/snapshots/" }
```

Dependency Used
```gradle
 compile 'com.michaelpardo:activeandroid:3.1.0-SNAPSHOT'
```

Add this meta-data to your **AndroidManifest.xml**
```xml
  <meta-data android:name="AA_DB_NAME" android:value="MyDatabase.db" />
  <meta-data android:name="AA_DB_VERSION" android:value="5" />
```

Create a class named MyApplication to initialize the ActiveAndroid library
```java
public class MyApplication extends Application {

    /*
    Initialized ActiveAndroid Library
     */

    @Override
    public void onCreate() {
        super.onCreate();

        //Initializing Active Android
        ActiveAndroid.initialize(this);
    }
}
```
Then you will need to define your class in your **AndroidManifest.xml** file 
```xml
<application
        android:name=".MyApplication"
```

Next you will create a model for the table
```java
//This is the Items table name
@Table(name = "Items")

public class Items extends Model {

    //The table consist only one field name
    @Column(name = "name")
    public String name;
}
```
Once the table model as been created you will need to define your models inside the **AndroidManifest.xml** file. 

```xml
        <meta-data
            android:name="AA_MODELS"
            android:value="packagename.TableName" />
            
            
            <meta-data
            android:name="AA_MODELS"
            android:value="androidproject.com.androidsqliteactiveandroid.Items" />
```




##### Reference

[Simplifiedcoding.net](https://www.simplifiedcoding.net/sqlite-crud-example-in-android-activeandroid/)
