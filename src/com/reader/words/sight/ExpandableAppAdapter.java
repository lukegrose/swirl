package com.reader.words.sight;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import com.reader.words.sight.model.SightWord;

public class ExpandableAppAdapter 
extends BaseExpandableListAdapter {
	
    private Context m_context;
    private List<Alphabet> m_groups;
    private List<List<Map<String, SightWord>>> m_children;

    public ExpandableAppAdapter(
    		Context context, 
    		List<Alphabet> groups, 
    		List<List<Map<String, SightWord>>> children) {
    	
        m_context = context;
        m_groups = groups;
        m_children = children;
    }

    @Override
    public Object getChild(int groupPos, int childPos) {
        return m_children.get(groupPos).get(childPos);
    }

    @Override
    public long getChildId(int groupPos, int childPos) {
        return childPos;
    }

    @Override
    public int getChildrenCount(int groupPos) {
        return m_children.get(groupPos).size();
    }

    @Override
    public View getChildView(int groupPos, int childPos, boolean isLastChild, View convertView, ViewGroup parent) {
    	
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(m_context);
            convertView = inflater.inflate(R.layout.selected_elv_child_row, null);
        }

        SightWord child = (SightWord)((Map)getChild(groupPos, childPos)).get("word");
        TextView txtView = (TextView)convertView.findViewById(R.id.grp_child);
        
        if (txtView != null) {
            txtView.setText(child.getValue().toLowerCase());
        }
        
        CheckBox cb = (CheckBox)convertView.findViewById(R.id.on_off_check_box);
        cb.setTag(child);
        
        cb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
        	
        	@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
			
//        		Toast.makeText(m_context, "Button checked: " 
//        				+ ((SightWord)buttonView.getTag()).getValue(), 
//        				Toast.LENGTH_SHORT).show();
        		
        		((SightWord)buttonView.getTag()).setHighlight(isChecked);
				
			}
        });
        
        cb.setChecked(child.isHighlighted());
        
        convertView.setFocusableInTouchMode(true);
        return convertView;
    }

    @Override
    public Object getGroup(int groupPos) {
        return m_groups.get(groupPos);
    }

    @Override
    public int getGroupCount() {
        return m_groups.size();
    }

    @Override
    public long getGroupId(int groupPos) {
        return groupPos;
    }

    @Override
    public View getGroupView(int groupPos, boolean isExpanded, View convertView, ViewGroup parent) {
    	
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(m_context);
            convertView = inflater.inflate(R.layout.selected_elv_group_row, null);
        }

        Alphabet group = (Alphabet)getGroup(groupPos);
        TextView txtView = (TextView)convertView.findViewById(R.id.row_name);
        
        if (txtView != null) {
            txtView.setText(group.toString());
        }

        return convertView;
    }
    @Override
    public boolean hasStableIds() {
        return false;
    }
    @Override
    public boolean isChildSelectable(int groupPos, int childPos) {
        return true;
    }
}