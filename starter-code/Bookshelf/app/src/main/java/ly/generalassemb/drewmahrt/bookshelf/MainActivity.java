package ly.generalassemb.drewmahrt.bookshelf;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //int count = 1;
    BaseAdapter mBookAdapter;

    //TODO: Define your ListView

    ListView listView;

    //TODO: Define your Book List

    List<Book> mBookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);

        //Use helper method to add books to the list
        mBookList = generateBooks();

        //TODO: Instantiate BaseAdapter
        //Below is a partially complete example for one Adapter
        mBookAdapter = new BaseAdapter() {
            @Override
            public int getCount() {

                return mBookList.size();
            }

            @Override
            public Object getItem(int position) {

                return mBookList.get(position);
            }

            @Override
            public long getItemId(int position) {

                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                //TODO: Update the view
                View view = convertView;

                if (view == null) {
                    LayoutInflater inflate =  (LayoutInflater) MainActivity.
                            this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = inflate.inflate(android.R.layout.simple_list_item_2, null);
                }

                TextView titleText = (TextView) view.findViewById(android.R.id.text1);
                TextView authorText = (TextView) view.findViewById(android.R.id.text2);

                titleText.setText("Title: " + mBookList.get(position).getTitle());
                authorText.setText("Author: " + mBookList.get(position).getAuthor());

                return view;
            }
        };

        //TODO: Set the ListView's adapter

        listView.setAdapter(mBookAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView titleText = (TextView) view.findViewById(android.R.id.text1);
                TextView authorText = (TextView) view.findViewById(android.R.id.text2);

                //if ((count % 2) == 1) {
                    titleText.setTextColor(Color.parseColor("#FF0000"));
                    authorText.setTextColor(Color.parseColor("#FF0000"));
                /*}
                else {
                    titleText.setTextColor(Color.parseColor("#000000"));
                    authorText.setTextColor(Color.parseColor("#000000"));
                }

                count++;*/

            }
        });


    }

    //Method to generate a list of Books
    private List<Book> generateBooks(){
        List<Book> books = new ArrayList<>();

        books.add(new Book("Apples Book","Brad"));
        books.add(new Book("Cats Book","Ryan"));
        books.add(new Book("Eagles Book","Kate"));
        books.add(new Book("Strawberries Cathy","Brad"));
        books.add(new Book("Dogs Book","Tom"));
        books.add(new Book("Ants Book","Zane"));

        return books;
    }
}
