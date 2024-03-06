import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.flamespace.R

class modal_popup : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_modal_popup, container, false)

        val roomCodeTextView = view.findViewById<TextView>(R.id.roomCodeTextView)

        // Get the room code from the arguments bundle
        val roomCode = arguments?.getString("ROOM_CODE")
        roomCodeTextView.text = roomCode

        return view
    }
}
