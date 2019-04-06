package com.example.cooperator_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CoopTermAdapter extends ArrayAdapter {
    List list = new ArrayList();

    public CoopTermAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add( CoopTerm object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount(){
        return list.size();
    }


    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        CoopTermHolder coopTermHolder;

        if(row==null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout1,parent,false);
            coopTermHolder = new CoopTermHolder();
            coopTermHolder.startDate = (TextView)row.findViewById(R.id.coopterm_startdate);
            coopTermHolder.endDate = (TextView)row.findViewById(R.id.coopterm_enddate);
            coopTermHolder.state = (TextView)row.findViewById(R.id.coopterm_state);
            row.setTag(coopTermHolder);
        }
        else{
            coopTermHolder = (CoopTermHolder)row.getTag();
        }
        CoopTerm  coopTerm = (CoopTerm) this.getItem(position);
        coopTermHolder.startDate.setText(coopTerm.getStartDate());
        coopTermHolder.endDate.setText(coopTerm.getEndDate());
        coopTermHolder.state.setText(coopTerm.getState());

        return row;
    }
    static class CoopTermHolder{
        TextView startDate,endDate,state;
    }
}
