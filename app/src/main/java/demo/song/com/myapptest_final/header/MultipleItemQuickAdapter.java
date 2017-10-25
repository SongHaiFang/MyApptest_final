package demo.song.com.myapptest_final.header;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import demo.song.com.myapptest_final.R;

public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {

    public MultipleItemQuickAdapter(List data) {
        super(data);
        addItemType(MultipleItem.TEXT, R.layout.text_view);
        addItemType(MultipleItem.IMG, R.layout.image_view);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()) {
            case MultipleItem.TEXT:
//                helper.setImageUrl(R.id.tv, item.getItemType());
                helper.setText(R.id.tv,item.getItemType());
                break;
            case MultipleItem.IMG:
//                helper.setImageUrl(R.id.iv, item.getContent());
                helper.setText(R.id.iv,item.getItemType());
                break;
        }
    }

}
