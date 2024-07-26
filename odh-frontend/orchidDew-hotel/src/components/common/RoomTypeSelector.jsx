import {useEffect, useState} from "react";
import {getRoomTypes} from "../utils/ApiFunctions.js";
import data from "bootstrap/js/src/dom/data.js";

const RoomTypeSelector = ({handleRoomInputChange, newRoom}) => {
    const [roomTypes, setRoomTypes] = useState([])
    const [showRoomTypeInput, setShowRoomTypeInput] = useState(false)
    const [newRoomType, setNewRoomType] = useState("")

    useEffect(() => {
        getRoomTypes().then((data) => {
            setNewRoomType(data)
        })
    }, []);

    const handleNewRoomTypeInputChange = (e) => {
        setNewRoomType(e.target.value)
    }

    const handleAddNewRoomType = () => {
        if (newRoomType !== "") {
            setRoomTypes([...roomTypes, newRoomType])
            setNewRoomType("")
            setShowRoomTypeInput(false)
        }
    }

    return (
        <>
            {roomTypes.length > 0 && (
                <div>
                    <select name="roomType" id="roomType" value={newRoom.roomType} onChange={(e) => {
                        if (e.target.value === "Add New") {
                            setShowRoomTypeInput(true)
                        } else {
                            handleRoomInputChange(e)
                        }
                    }}>
                        <option value={""}>select a room type</option>
                        <option value={"Add New"}>Add New</option>
                        {roomTypes.map((type, index) => (
                            <option key={index} value={type}>
                                {type}
                            </option>
                        ))}
                    </select>
                    {setShowRoomTypeInput && (
                        <div className="input-group">
                            <input
                                type="text"
                                className="form-control"
                                placeholder="Enter a new room type"
                                onChange={handleNewRoomTypeInputChange}
                            />
                            <button className="btn btn-hotel" type='button' onClick={handleAddNewRoomType}>
                                Add
                            </button>
                        </div>
                    )}
                </div>
            )}
        </>
    )
}

export default RoomTypeSelector