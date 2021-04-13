package com.example.games.adapter;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.game_common.data.ServerData;
import com.example.game_common.data.StatusData;
import com.example.game_common.utils.ClickableMovementMethod;
import com.example.game_common.utils.SpannableStringUtils;
import com.example.game_common.utils.Utils;
import com.example.game_lol.LoLMainActivity;
import com.example.games.R;
import com.example.games.utils.ConstantsKt;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;

/**
 * 文 件 名: AnimationAdapter
 * 创 建 人: Allen
 * 创建日期: 16/12/24 15:33
 * 邮   箱: AllenCoder@126.com
 * 修改时间：
 * 修改备注：
 */
public class AnimationAdapter extends BaseQuickAdapter<StatusData, BaseViewHolder> {
    private Context mContext;
    public AnimationAdapter(Context context) {
        super(R.layout.item_layout_animation, ServerData.getGamesList());
        mContext = context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, StatusData item) {
        switch (helper.getLayoutPosition() % 3) {
            case 0:
                helper.setImageResource(R.id.img, R.mipmap.animation_img1);
                setText(helper, Utils.getContext().getString(R.string.lol), Utils.getContext().getString(R.string.lol_introduce), createClickableSpan(mContext, 0));
                break;
            case 1:
                helper.setImageResource(R.id.img, R.mipmap.animation_img2);
                setText(helper, Utils.getContext().getString(R.string.DNF), Utils.getContext().getString(R.string.DNF_introduce), createClickableSpan(mContext, 1));
                break;
            case 2:
                helper.setImageResource(R.id.img, R.mipmap.animation_img3);
                setText(helper, Utils.getContext().getString(R.string.CSGO), Utils.getContext().getString(R.string.CSGO_introduce), createClickableSpan(mContext, 2));
                break;
            default:
                break;
        }

    }


    private ClickableSpan createClickableSpan(Context context, int position){
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                switch (position) {
                    case 0:
                        ConstantsKt.lolMainStart(context);
                        break;
                    case 1:

                        break;
                    case 2:
                        ConstantsKt.lolMainStart(context);
                        break;
                }

            }
            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(getContext().getResources().getColor(R.color.clickspan_color));
                ds.setUnderlineText(true);
            }
        };

        return clickableSpan;
    }

    private void setText(BaseViewHolder helper, String tweetName, String msg, ClickableSpan clickableSpan) {
        helper.setText(R.id.tweetName, tweetName);
        ((TextView) helper.getView(R.id.tweetText)).setText(SpannableStringUtils.getBuilder(msg).append("查看详情").setClickSpan(clickableSpan).create());
        ((TextView) helper.getView(R.id.tweetText)).setMovementMethod(ClickableMovementMethod.getInstance());
        ((TextView) helper.getView(R.id.tweetText)).setFocusable(false);
        ((TextView) helper.getView(R.id.tweetText)).setClickable(false);
        ((TextView) helper.getView(R.id.tweetText)).setLongClickable(false);
    }


}
