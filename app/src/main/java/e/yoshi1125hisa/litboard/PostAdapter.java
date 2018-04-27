package e.yoshi1125hisa.litboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class PostAdapter extends ArrayAdapter<Post> {

    List<Post> item;

    public PostAdapter(Context context, int resource, List<Post> objects) {
        super(context, resource, objects);
        item = objects;
    }

    @Override
    public int getCount(){
        return  item.size();
    }

    @Override
    public Post getItem(int position){
        return  item.get(position);
    }


        @Override
        public View getView ( int position, View convertView, ViewGroup parent) {
            Post item = getItem(position);
            final ViewHolder viewHolder;

            if (convertView != null) {
                viewHolder = (ViewHolder) convertView.getTag();
            } else {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_item_post, parent, false);

                viewHolder = new ViewHolder();
                viewHolder.usernameText = convertView.findViewById(R.id.username);
                viewHolder.passText = convertView.findViewById(R.id.pass);
                viewHolder.atText = convertView.findViewById(R.id.at);
                viewHolder.mailText = convertView.findViewById(R.id.mail);
                viewHolder.inchText = convertView.findViewById(R.id.inch);
                viewHolder.inchXText = convertView.findViewById(R.id.inchX);
                viewHolder.inchYText = convertView.findViewById(R.id.inchY);
                viewHolder.dpiXText = convertView.findViewById(R.id.dpiX);
                viewHolder.dpiYText = convertView.findViewById(R.id.dpiY);
                viewHolder.realScrWidth = convertView.findViewById(R.id.realWidth);
                viewHolder.realScrHeight = convertView.findViewById(R.id.realHeight);
                viewHolder.modelName = convertView.findViewById(R.id.modelName);
                viewHolder.dpX = convertView.findViewById(R.id.dpX);
                viewHolder.dpY = convertView.findViewById(R.id.dpY);
              /*  viewHolder.realInchX = convertView.findViewById(R.id.realInchX);
                viewHolder.realInchY = convertView.findViewById(R.id.realInchY);
                viewHolder.realInch = convertView.findViewById(R.id.realInch);
                */
              convertView.setTag(viewHolder);
            }

            viewHolder.dpiXText.setText(item.getDpiX());
            viewHolder.dpiYText.setText(item.getDpiY());

            viewHolder.usernameText.setText(item.getUserName());
            viewHolder.passText.setText(item.getPass());
            viewHolder.atText.setText(item.getAt());
            viewHolder.mailText.setText(item.getMail());
            viewHolder.inchText.setText(item.getInch());
            viewHolder.inchXText.setText(item.getInchX());
            viewHolder.inchYText.setText(item.getInchY());

            viewHolder.realScrHeight.setText(item.getRealScreenHeight());
            viewHolder.realScrWidth.setText(item.getRealScreenWidth());

            viewHolder.dpX.setText(item.getDpX());
            viewHolder.dpY.setText(item.getDpY());
          /*  viewHolder.realInchX.setText(item.getRealInchX());
            viewHolder.realInchY.setText(item.getRealInchY());
            viewHolder.realInch.setText(item.getRealInch());
*/
            return convertView;
        }
    static class ViewHolder{

        TextView dpiXText;
        TextView dpiYText;

        TextView usernameText;
        TextView atText;
        TextView passText;
        TextView mailText;
        TextView inchText;
        TextView inchXText;
        TextView inchYText;
        TextView realScrHeight;
        TextView realScrWidth;
        TextView modelName;
        TextView dpX;
        TextView dpY;
      /*  TextView realInchX;
        TextView realInchY;
        TextView realInch;
   */ }
}
