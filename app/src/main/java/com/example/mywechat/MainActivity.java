package com.example.mywechat;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {
    private Fragment mTab01=new WeChatFragment();
    private Fragment mTab02=new FriendFragment();
    private Fragment mTab03=new ContactFragment();
    private Fragment mTab04=new SettingFragment();

    private  TextView title;
    private RecyclerView detail;
    FragmentManager fm;

    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSettings;

    private ImageButton mImgWeixin;
    private ImageButton mImgFrd;
    private ImageButton mImgAddress;
    private ImageButton mImgSettings;

    private static final String TAG = MainActivity.class.getSimpleName();

    private List<String> mList = new ArrayList<>();

    private List<StickyData> mDataList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        initFragment();
        selectfragment(0);
        intEvent();

        initList();
        initData();
    }

    private void initList() {
        mList.add("2015年|回归中国发展");
        mList.add("2015年|成立个人工作室");
        mList.add("2015年|参加极限挑战第一季");

        mList.add("2016年|参加极限挑战第二季");
        mList.add("2016年|参演电视剧好先生");
        mList.add("2016年|参演电视剧老九门及番外");
        mList.add("2016年|参演电影闭嘴爱吧");
        mList.add("2016年|自作曲独角戏");
        mList.add("2016年|首张solo专辑《Lose Control》");
        mList.add("2016年|薇姿品牌天猫直播");
        mList.add("2016年|代言可爱多、曼妥思、汰渍");
        mList.add("2016年|代言华为nova");
        mList.add("2016年|FENDI开业嘉宾");
        mList.add("2016年|CHAUMET品牌雅绅");
        mList.add("2016年|为母校捐赠钢琴和100万奖学金");
        mList.add("2016年|湖南共青团宣传推广大使");
        mList.add("2016年|芭莎慈善夜捐款70万");
        mList.add("2016年|最受欢迎新人奖");
        mList.add("2016年|最受欢迎电影歌曲");
        mList.add("2016年|最佳男配角");
        mList.add("2016年|《而立.24》畅销");
        mList.add("2016年|多次登上时尚杂志封面");

        mList.add("2017年|参演电影功夫瑜伽");
        mList.add("2017年|参演电视剧求婚大作战");
        mList.add("2017年|参演电影建军大业");
        mList.add("2017年|配音赛车总动员3");
        mList.add("2017年|荣获最佳男配角");
        mList.add("2017年|参加极限挑战第三季");
        mList.add("2017年|专辑《SHEEP》");
        mList.add("2017年|代言纯甄");
        mList.add("2017年|代言Converse");
        mList.add("2017年|Valentino 中国区首位品牌大使");
        mList.add("2017年|妙卡首位中国品牌代言人");
        mList.add("2017年|代言美拍");
        mList.add("2017年|代言小熊电器");
        mList.add("2017年|向上向善湖南好青年称号");
        mList.add("2017年|年度全能艺人");
        mList.add("2017年|最佳男歌手及年度专辑");
        mList.add("2017年|微博FANS选择奖");
        mList.add("2017年|年度先生荣誉");
        mList.add("2017年|《SHEEP》年度专辑");

        mList.add("2018年|《偶像练习生》张PD");
        mList.add("2018年|春节联欢晚会");
        mList.add("2018年|东方风云音乐榜");
        mList.add("2018年|参加极限挑战第四季");
        mList.add("2018年|五四晚会");
        mList.add("2018年|爱奇艺世界大会");
        mList.add("2018年|Lollapalooza音乐节");
        mList.add("2018年|参演电影《一出好戏》");
        mList.add("2018年|中国音乐公告牌");
        mList.add("2018年|釜山音乐节");
        mList.add("2018年|代言碧欧泉");
        mList.add("2018年|《即刻电音》");
        mList.add("2018年|《由你音乐榜》");
        mList.add("2018年|湖南卫跨年晚会");
        mList.add("2018年|美国出道");
        mList.add("2018年|《NAMANANA》");
        mList.add("2018年|最佳制作人");
        mList.add("2018年|最佳专辑");
        mList.add("2018年|最受欢迎男歌手");
        mList.add("2018年|2018百度娱乐人物");

        mList.add("2019年|发行EP《HONEY》");
        mList.add("2019年|单曲《我不好》");
        mList.add("2019年|单曲《晚安》");
        mList.add("2019年|单曲《外婆》");
        mList.add("2019年|合作曲《Let's Shut Up and Dance》");
        mList.add("2019年|合作曲《Lovebird》");
        mList.add("2019年|纯音乐《SKY》");
        mList.add("2019年|单曲《青春颂》");
        mList.add("2019年|合作曲《无人之域》");
        mList.add("2019年|璀璨启程乐享会");
        mList.add("2019年|合作曲《新春》");
        mList.add("2019年|合作曲《晴空谣》");
        mList.add("2019年|央视春晚《中国喜事》");
        mList.add("2019年|央视元宵晚会《麻婆豆腐》");
        mList.add("2019年|《青春有你》");
        mList.add("2019年|央视五四晚会");
        mList.add("2019年|《大航海》七场");
        mList.add("2019年|参加极限挑战第五季");
        mList.add("2019年|爱奇艺尖叫之夜");
        mList.add("2019年|腾讯音乐盛典");
        mList.add("2019年|东方卫视跨年晚会");
        mList.add("2018年|参演电视剧《黄金瞳》");
        mList.add("2018年|参演电影《一切如你》");
        mList.add("2018年|参演电视剧《大明风华》");
        mList.add("2019年|央视元宵晚会《麻婆豆腐》");
        mList.add("2019年|综艺《掌掌眼》");
        mList.add("2019年|《归零》");
        mList.add("2019年|《十一书》");
        mList.add("2019年|《我们在行动》");
        mList.add("2019年|《夜归人》");
        mList.add("2019年|第61届格莱美颁奖礼 动感101音乐大使");
        mList.add("2019年|纽约大都会博物馆慈善晚会");
        mList.add("2019年|香港慈善晚宴");
        mList.add("2019年|Valentino高定秀");
        mList.add("2019年|MAC亚太区代言人");
        mList.add("2019年|CK中国首位全球代言人");
        mList.add("2019年|DW代言人");
        mList.add("2019年|HM代言人");
        mList.add("2019年|爱奇艺VIP代言人");
        mList.add("2019年|Perrier代言人");
        mList.add("2019年|春夏代言人");
        mList.add("2019年|王老吉代言人");
        mList.add("2019年|必胜客代言人");
        mList.add("2019年|梦幻西游手游代言人");
        mList.add("2019年|Layciga合作人&设计师");
        mList.add("2019年|最佳男配角");
        mList.add("2019年|2019亚洲全能艺人");
        mList.add("2019年|2019年度音乐制作人");
        mList.add("2019年|《NAMANANA》年度畅销数字专辑");
        mList.add("2019年|年度最受欢迎内地男歌手");
        mList.add("2019年|QQ音乐巅峰歌手");
        mList.add("2019年|最佳编曲奖《梦不落雨林》");
        mList.add("2019年|年度金曲奖《HONEY》");
        mList.add("2019年|年度MV十大畅销作品/十大华语专辑/十大内地歌手");
        mList.add("敬请期待......|");
    }

    private void initData() {
        for (int i = 0; i < mList.size(); i++) {
            StickyData bean = new StickyData();

            String s = mList.get(i);
            // area
            String year = s.substring(0, s.indexOf("|"));
            // team
            String trend = s.substring(s.indexOf("|") + 1, s.length());

            bean.setArea(year);
            bean.setTeam(trend);

            mDataList.add(bean);
        }

        Log.d(TAG, "initData: " + mDataList.size());
    }

    private void initView() {
        mTabWeixin=(LinearLayout)findViewById(R.id.id_tab_weixin);
        mTabFrd=(LinearLayout)findViewById(R.id.id_tab_friend);
        mTabAddress=(LinearLayout)findViewById(R.id.id_tab_contact);
        mTabSettings=(LinearLayout)findViewById(R.id.id_tab_settings);

        mImgWeixin=(ImageButton)findViewById(R.id.image_weixin);
        mImgFrd=(ImageButton)findViewById(R.id.image_friend);
        mImgAddress=(ImageButton)findViewById(R.id.image_contact);
        mImgSettings=(ImageButton)findViewById(R.id.image_settings);

        title=(TextView)findViewById(R.id.tv_sticky_header_view);
        detail=(RecyclerView)findViewById(R.id.rcv_sticky);

        StickyAdapter adapter = new StickyAdapter(this);

        RecyclerView rcvSticky = findViewById(R.id.rcv_sticky);
        final TextView tvArea = findViewById(R.id.tv_sticky_header_view);

        rcvSticky.setLayoutManager(new LinearLayoutManager(this));
        rcvSticky.setHasFixedSize(true);
        rcvSticky.setAdapter(adapter);

        adapter.setStickyDataList(mDataList);

        rcvSticky.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                View stickyInfoView = recyclerView.findChildViewUnder(
                        tvArea.getMeasuredWidth() / 2, 5);
                if (stickyInfoView != null && stickyInfoView.getContentDescription() != null) {
                    tvArea.setText(String.valueOf(stickyInfoView.getContentDescription()));
                }
                View transInfoView = recyclerView.findChildViewUnder(
                        tvArea.getMeasuredWidth() / 2, tvArea.getMeasuredHeight() + 1);
                if (transInfoView != null && transInfoView.getTag() != null) {
                    int transViewStatus = (int) transInfoView.getTag();
                    int dealtY = transInfoView.getTop() - tvArea.getMeasuredHeight();
                    if (transViewStatus == StickyAdapter.HAS_STICKY_VIEW) {
                        if (transInfoView.getTop() > 0) {
                            tvArea.setTranslationY(dealtY);
                        } else {
                            tvArea.setTranslationY(0);
                        }
                    } else if (transViewStatus == StickyAdapter.NONE_STICKY_VIEW) {
                        tvArea.setTranslationY(0);
                    }
                }
            }
        });
    }
    private void initFragment(){
        fm=getFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.add(R.id.id_content,mTab01);//第一个参数为int型
        transaction.add(R.id.id_content,mTab02);
        transaction.add(R.id.id_content,mTab03);
        transaction.add(R.id.id_content,mTab04);
        transaction.commit();
    }

    private void intEvent(){
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSettings.setOnClickListener(this);
    }

    private void hidefragment(FragmentTransaction transaction){
        transaction.hide(mTab01);
        transaction.hide(mTab02);
        transaction.hide(mTab03);
        transaction.hide(mTab04);
    }

    private void selectfragment(int i){
        FragmentTransaction transaction=fm.beginTransaction();
        hidefragment(transaction);
        switch (i){
            case 0:
                transaction.show(mTab01);
                mImgWeixin.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                transaction.show(mTab02);
                mImgFrd.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                transaction.show(mTab03);
                mImgAddress.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                transaction.show(mTab04);
                mImgSettings.setImageResource(R.drawable.tab_settings_pressed);
                break;
            default:
                break;
        }
        transaction.commit();
    }


    public void onClick(View v){//点击响应
        resetimg();
        switch (v.getId()){
            case R.id.id_tab_weixin:
                selectfragment(0);
                title.setVisibility(View.GONE);
                detail.setVisibility(View.GONE);
                break;
            case R.id.id_tab_friend:
                selectfragment(1);
                title.setVisibility(View.VISIBLE);
                detail.setVisibility(View.VISIBLE);
                break;
            case R.id.id_tab_contact:
                selectfragment(2);
                title.setVisibility(View.GONE);
                detail.setVisibility(View.GONE);
                break;
            case R.id.id_tab_settings:
                selectfragment(3);
                title.setVisibility(View.GONE);
                detail.setVisibility(View.GONE);
                break;
            default:
                title.setVisibility(View.GONE);
                detail.setVisibility(View.GONE);
                break;
        }
    }

    public void resetimg(){
        mImgWeixin.setImageResource(R.drawable.tab_weixin_normal);
        mImgFrd.setImageResource(R.drawable.tab_find_frd_normal);
        mImgAddress.setImageResource(R.drawable.tab_address_normal);
        mImgSettings.setImageResource(R.drawable.tab_settings_normal);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}