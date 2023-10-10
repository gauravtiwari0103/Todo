package com.gaurav.leraning

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RvAdapter(private val dataSet: ArrayList<Response>) :
    RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val leaveType : TextView
        val time: TextView
        val btn: Button
        val tvSrno: TextView

        init {
            // Define click listener for the ViewHolder's View
            title = view.findViewById(R.id.tvTitle)
            leaveType= view.findViewById(R.id.tvDate)
            time = view.findViewById(R.id.tvTime)
            btn = view.findViewById(R.id.btnReassign)
            tvSrno = view.findViewById(R.id.tvsrno)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.single_todo_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.title.text = "${dataSet[position].FromDate} - ${dataSet[position].ToDate}"
        viewHolder.leaveType.text = dataSet[position].LeaveType
        viewHolder.time.text = "${dataSet[position].FromDate} to ${dataSet[position].ToDate}"
        viewHolder.btn.text = dataSet[position].Status
        viewHolder.tvSrno.text = "${position+1}"

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
