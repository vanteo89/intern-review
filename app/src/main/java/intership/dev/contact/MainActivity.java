package intership.dev.contact;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import intership.dev.fragment.ListUserFragment;


public class MainActivity extends Activity {
    public static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomActionBar();
        display_fragment(0);
    }
    public void CustomActionBar() {
        ActionBar mActionBar = getActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
       mActionBar.setDisplayShowTitleEnabled(false);
       mActionBar.setHomeButtonEnabled(false);
        mActionBar.setCustomView(R.layout.custom_actionbar);
        ImageView imageleft = (ImageView) mActionBar.getCustomView().findViewById(R.id.imgMuiTenLeft);
        imageleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display_fragment(0);
            }
        });

        mActionBar.setDisplayShowCustomEnabled(true);
    }

    public void display_fragment(int pos) {
        Fragment fragment = null;
        switch (pos) {
            case 0:
                fragment = new ListUserFragment();
                break;
        }
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fra, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
