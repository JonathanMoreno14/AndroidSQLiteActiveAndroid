package androidproject.com.androidsqliteactiveandroid;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;

/**
 * Created by Jonathan on 6/23/2016.
 */

//This is the Items table name
@Table(name = "Items")

public class Items extends Model {

    //The table consist only one field name
    @Column(name = "name")
    public String name;
}
