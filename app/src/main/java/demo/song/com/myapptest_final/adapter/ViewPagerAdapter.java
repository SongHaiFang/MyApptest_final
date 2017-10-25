package demo.song.com.myapptest_final.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/**
 * 
 * 
 * ViewPager������
 * @author lenovo
 *
 */
public class ViewPagerAdapter extends PagerAdapter{

	private List<View> list;
	public ViewPagerAdapter(List<View> list) {
		super();
		this.list = list;
	}
	//ҳ������
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}
	//���View==Object����true  Object��instantiateItem(ViewGroup container���ص�
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0==arg1;
	}
	//���λ�ú���ͼ ����λ�õ�ͼƬ��ӵ�ViewGroup
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		
		container.addView(list.get(position%list.size()));
		
		return list.get(position%list.size());
	}
	//����ͼ��λ�ô�ViewGroupɾ��
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		container.removeView(list.get(position%list.size()));
	}

}
