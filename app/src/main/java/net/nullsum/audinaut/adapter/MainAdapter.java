/*
  This file is part of Subsonic.
	Subsonic is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.
	Subsonic is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
	GNU General Public License for more details.
	You should have received a copy of the GNU General Public License
	along with Subsonic. If not, see <http://www.gnu.org/licenses/>.
	Copyright 2015 (C) Scott Jackson
*/

package net.nullsum.audinaut.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.List;

import net.nullsum.audinaut.R;
import net.nullsum.audinaut.util.Util;
import net.nullsum.audinaut.view.BasicHeaderView;
import net.nullsum.audinaut.view.BasicListView;
import net.nullsum.audinaut.view.UpdateView;

public class MainAdapter extends SectionAdapter<Integer> {
	public static final int VIEW_TYPE_ALBUM_LIST = 1;

	public MainAdapter(Context context, List<String> headers, List<List<Integer>> sections, OnItemClickedListener onItemClickedListener) {
		super(context, headers, sections);
		this.onItemClickedListener = onItemClickedListener;
	}

	@Override
	public UpdateView.UpdateViewHolder onCreateSectionViewHolder(ViewGroup parent, int viewType) {
		UpdateView updateView = new BasicListView(context);
		return new UpdateView.UpdateViewHolder(updateView);
	}

	@Override
	public void onBindViewHolder(UpdateView.UpdateViewHolder holder, Integer item, int viewType) {
		UpdateView updateView = holder.getUpdateView();

		if(viewType == VIEW_TYPE_ALBUM_LIST) {
			updateView.setObject(context.getResources().getString(item));
		} else {
			updateView.setObject(item);
		}
	}

	@Override
	public int getItemViewType(Integer item) {
		return VIEW_TYPE_ALBUM_LIST;
	}

	@Override
	public UpdateView.UpdateViewHolder onCreateHeaderHolder(ViewGroup parent) {
		return new UpdateView.UpdateViewHolder(new BasicHeaderView(context, R.layout.album_list_header));
	}
	@Override
	public void onBindHeaderHolder(UpdateView.UpdateViewHolder holder, String header, int sectionIndex) {
		UpdateView view = holder.getUpdateView();
		CheckBox checkBox = (CheckBox) view.findViewById(R.id.item_checkbox);

		String display;
		if("songs".equals(header)) {
			display = context.getResources().getString(R.string.search_songs);
			checkBox.setVisibility(View.GONE);
		} else {
			display = header;
			checkBox.setVisibility(View.GONE);
		}

		if(view != null) {
			view.setObject(display);
		}
	}
}
