package com.example.koindi_roomdatabase.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.AsyncListUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.koindi_roomdatabase.databinding.ItemNoteBinding
import com.example.koindi_roomdatabase.db.NoteEntity

class NoteAdapter:RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    private lateinit var binding: ItemNoteBinding
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        binding=ItemNoteBinding.inflate(inflater,parent,false)
        return ViewHolder()
    }

    override fun getItemCount(): Int =differ.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
        holder.setIsRecyclable(false)
    }
    inner class ViewHolder():RecyclerView.ViewHolder(binding.root){
            @SuppressLint("SetTextI18n")
            fun bind(item: NoteEntity) {
                binding.apply {
                    tvTitle.text = item.noteTitle
                    tvDescp.text = item.noteDesc
                }
            }
    }

    private val differCallback = object : DiffUtil.ItemCallback<NoteEntity>() {
        override fun areItemsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
            return oldItem.noteId == newItem.noteId
        }

        override fun areContentsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
            return oldItem == newItem
        }
    }
    val differ=AsyncListDiffer(this,differCallback)

}