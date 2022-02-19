<?php

namespace App\Exceptions;

use Exception;
use Illuminate\Http\JsonResponse;
use Illuminate\Support\Facades\Log;

class DatabaseException extends Exception
{
    //
    //
    protected $message;
    protected $status_code;

    public function __construct($message = "", $code = 500)
    {
        echo $this->message;
        if ($message != "") {
            $this->message = $message;
        } else {
            $this->message = config('constants.DATABASE_ERROR');
        }

        $this->status_code = $code;
        parent::__construct($message, $code);
    }

    public function report(){

        Log::error($this->getMessage() .$this->getCode()  );
    }

    /**
     * @return JsonResponse
     */
    public function render(){
        return response()->json(["error" => true, "message" => $this->getMessage(), "code" => $this->code], $this->status_code);
    }
}
