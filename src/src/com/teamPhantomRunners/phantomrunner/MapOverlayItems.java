package com.teamPhantomRunners.phantomrunner;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

public class MapOverlayItems extends ItemizedOverlay {

	private ArrayList<OverlayItem> mapOverlays = new ArrayList<OverlayItem>();
	private Context mapContext;
	
	public MapOverlayItems(Drawable defaultMarker, Context context) {
		
		super(boundCenterBottom(defaultMarker));
		mapContext = context;
		// TODO Auto-generated constructor stub
	}

	public void addOverlay(OverlayItem overlay)
	{
		mapOverlays.add(overlay);
		populate();
	}
	
	@Override
	protected OverlayItem createItem(int i)
	{
		return mapOverlays.get(i);
	}
	
	@Override
	public int size()
	{
		return mapOverlays.size();
	}
	@Override
	protected boolean onTap(int index)
	{
		OverlayItem item = mapOverlays.get(index);
		AlertDialog.Builder dialog = new AlertDialog.Builder(mapContext);
		dialog.setTitle(item.getTitle());
		dialog.setMessage(item.getSnippet());
		dialog.show();
		return true;
	}
	/*
	public void draw(Canvas canvas, MapView mapView, boolean shadow)
	{
		super.draw(canvas, mapView, shadow);
		
		Paint paint = new Paint();
		
	}*/

}
