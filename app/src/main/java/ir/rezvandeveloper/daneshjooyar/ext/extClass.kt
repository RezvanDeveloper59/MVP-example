package ir.rezvandeveloper.daneshjooyar.ext

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import ir.rezvandeveloper.daneshjooyar.databinding.SupportDialogBinding


class extClass {

    companion object {

        fun dialogSupport(context: Context) {
            val binding:SupportDialogBinding = SupportDialogBinding.inflate(LayoutInflater.from(context))

            val dialog = Dialog(context)
            dialog.setContentView(binding.root)

            binding.btnSendSupport.setOnClickListener {
                val title = binding.etTitleSupport.text.toString()
                val message = binding.etMessageSupport.text.toString()
                val text = "عنوان : $title\nمتن پیام :$message"
                ApiRepository.sendText("TH5lYGWzl8FHDY6rNw3daOgB6RACnLBFjDOqs8wD", text)
            }

            dialog.create()
            dialog.show()

            binding.ivCancelSupport.setOnClickListener{
                dialog.dismiss()
            }
        }
    }
}