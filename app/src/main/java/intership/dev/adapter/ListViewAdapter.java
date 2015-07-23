package intership.dev.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import intership.dev.contact.MainActivity;
import intership.dev.contact.R;
import intership.dev.fragment.UserFragment;

/**
 * Created by vanteo89 on 7/23/2015.
 */
public class ListViewAdapter extends BaseAdapter {
    String[] mArrayTexts;
    Integer[] mArrayImage;
    Context context;
    int mLayoutId;
    int mpos;
    ViewHolder viewHolder;

    public ListViewAdapter(Context context, int mLayoutId, String[] mArrayTexts, Integer[] mArrayImage) {
        this.context = context;
        this.mArrayTexts = mArrayTexts;
        this.mLayoutId = mLayoutId;
        this.mArrayImage = mArrayImage;
    }

    @Override
    public int getCount() {
        return mArrayTexts.length;
    }

    @Override
    public Object getItem(int position) {
        return mArrayTexts[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mpos = position;
        viewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(mLayoutId, parent, false);
            viewHolder.img_Avatar = (ImageView) convertView.findViewById(R.id.img_nu);
            viewHolder.txt_Info = (TextView) convertView.findViewById(R.id.tv_nu);
            viewHolder.img_edit = (ImageView) convertView.findViewById(R.id.img_edit);
            viewHolder.img_edit.setTag(mpos);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String mInFo = mArrayTexts[position];
        int mImage = mArrayImage[position];
        viewHolder.txt_Info.setText(mInFo);
        viewHolder.img_Avatar.setImageResource(mImage);
        viewHolder.img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpos = Integer.parseInt(v.getTag().toString());
                //  Toast.makeText(context, "Selected :" + mpos, Toast.LENGTH_LONG).show();
                UserFragment userFragment = new UserFragment();
                Bundle bundle = new Bundle();
                bundle.putString("info", mArrayTexts[mpos]);
                userFragment.setArguments(bundle);
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fra, userFragment).commit();

            }
        });

        return convertView;
    }



    public class ViewHolder {
        ImageView img_Avatar, img_edit;
        TextView txt_Info;
    }
}
