package androidproject.com.androidsqliteactiveandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.activeandroid.query.Update;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText addItemText;
    Button addItemBtn;
    Button deleteItemBtn;
    ListView listItems;


    //Array list for storing all the Items
     ArrayList<String> addListedItems;

    //Adapter for listview
     ArrayAdapter listItemsAdapter;

    //item obj
    Items newItemObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        addItemText = (EditText) findViewById(R.id.editText);
        addItemBtn = (Button) findViewById(R.id.button);
        deleteItemBtn = (Button)findViewById(R.id.button2);
        listItems = (ListView) findViewById(R.id.listView);


        addListedItems = new ArrayList<>();

        addItemBtn.setOnClickListener(this);


        deleteItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItems();
            }
        });

        showItemList();

    }


    public List<Items> getAll() {
        //Getting all items stored in Items table
        return new Select()
                .from(Items.class)
                .orderBy("Name ASC")
                .execute();
    }



    public void showItemList() {
        //Creating a list and getting all inventories from the method
        List<Items> allItems = getAll();

        //Adding all the items of the inventories to arraylist
        for (int i = 0; i < allItems.size(); i++) {
            Items inventory = allItems.get(i);
            addListedItems.add(inventory.name);
        }

        //Creating our adapter
        listItemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, addListedItems);

        //Adding adapter to listview
        listItems.setAdapter(listItemsAdapter);

        //Updating the inventory list
         updateItemList();
    }



    public void saveItems() {
        //Getting name from editText
        String name = addItemText.getText().toString().trim();

        //Checking if name is blank
        if (name.equalsIgnoreCase("")) {
            Toast.makeText(this, "Please enter a items", Toast.LENGTH_LONG).show();
            return;
        }

        //If name is not blank creating a new Item object
         newItemObj = new Items();
        //Adding the given name to inventory name
        newItemObj.name = name;
        //Saving name to sqlite database
        newItemObj.save();

        //Displaying a toast message for successfull insertion
        Toast.makeText(this, "Items Saved Successfully", Toast.LENGTH_LONG).show();
    }


    public void updateItemList() {
        listItemsAdapter.notifyDataSetChanged();
    }

    public void deleteItems(){
        new Delete().from(Items.class).execute();
       //showItemList();
        //updateItemList();

    }

    @Override
    public void onClick(View v) {
        saveItems();
        //showItemList();
    }

}

