package mobiles.cucei.seguridaduniversitaria.AssaultActivities

import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Switch
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_incident_details.*
import kotlinx.android.synthetic.main.section_header.*
import mobiles.cucei.seguridaduniversitaria.Data.Incidente
import mobiles.cucei.seguridaduniversitaria.Data.Usuario
import mobiles.cucei.seguridaduniversitaria.R

class IncidentDetails : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    private lateinit var lastLocation: Location

    private var user:Usuario = Usuario()
    private val gdl = LatLng(20.659699, -103.349609)
    private var incident:Incidente = Incidente()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_incident_details)

        section_header_text_header.text = "Datos del Incidente"
        section_header_image_header.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_assignment_black_24dp))

        user = intent.getSerializableExtra("user") as Usuario

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera

        mMap.addMarker(MarkerOptions().position(gdl).title("Guadalajara"))
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isMyLocationButtonEnabled = true
        mMap.uiSettings.setAllGesturesEnabled(true)

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gdl,10f))

        setUpMap()
    }

    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
            return
        }

        mMap.isMyLocationEnabled = true

    }

    fun insideCenterToggle(view: View){
        val switch = view as Switch
        if (switch.isChecked){
            incident.local = true
            when(user.centro){
                "CUCEI" -> setMarkerLocation(20.65533543427295,-103.32559246656251,user.centro)
                "CUCEA" -> setMarkerLocation(20.740783427481432,-103.38087558746338,user.centro)
                "CUAAD" -> setMarkerLocation(20.74060282394747,-103.31216812133789,user.centro)
                "CUCSH" -> setMarkerLocation(20.693457935368478,-103.35012674331665,user.centro)
                "CUCBA" -> setMarkerLocation(20.74596063711394,-103.51288318634033,user.centro)
                "CUCS" -> setMarkerLocation(20.685789734395968,-103.33175897598267,user.centro)
            }
        }else{
            setMarkerLocation(gdl.latitude,gdl.longitude,"Guadalajara")
        }

    }

    fun onNext(view: View){
        incident.city = incident_details_edit_text_locality.text.toString()
        incident.location_description = incident_details_edit_text_place.text.toString()
        if (!incident_details_edit_text_victims_number.text.toString().isEmpty()){
            incident.num_victims = incident_details_edit_text_victims_number.text.toString().toInt()
        }

        val intent = Intent(this,IncidentDetailsType::class.java)
        intent.putExtra("user",user)
        intent.putExtra("incident",incident)
        startActivity(intent)
    }

    private fun setMarkerLocation(lat:Double,lon:Double,title:String){
        val marker = LatLng(lat,lon)
        incident.lat = lat
        incident.lon = lon
        mMap.clear()
        mMap.addMarker(MarkerOptions().position(marker).title(title))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker,14f))
    }
}
