package edu.itesm.stanley

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class ActorsAdapter(private val actors : List<Actor>)
    : RecyclerView.Adapter<ActorsAdapter.ActorViewHolder>() {

    inner class ActorViewHolder(renglon: View) : RecyclerView.ViewHolder(renglon){
        var name = renglon.findViewById<TextView>(R.id.name)
        var movie = renglon.findViewById<TextView>(R.id.movie)
        var info = renglon.findViewById<TextView>(R.id.info)
        var photo = renglon.findViewById<ImageView>(R.id.photo)
    }

    //Crea el renglón
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val renglon_vista = inflater.inflate(R.layout.actors_renglon,parent, false)
        return ActorViewHolder(renglon_vista)
    }

    //Asocia datos con los elementos del renglón
    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        val actor= actors[position]
        holder.photo.setImageResource(actor.photo)
        holder.name.text = actor.name
        holder.movie.text = actor.movie
        holder.info.text = actor.info
        holder.itemView.setOnClickListener {
           val actiondos = ActorskFragmentDirections.actionActorskFragmentToActorFragment2(actor)
           holder.itemView.findNavController().navigate(actiondos)
        }
    }

    // Cuantos elementos tiene la lista
    override fun getItemCount(): Int {
        return actors.size
    }
}